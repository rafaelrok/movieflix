import jwtDecode from 'jwt-decode';
import { getAuthData } from './storage';

export type Role = 'ROLE_VISITOR' | 'ROLE_MEMBER';

type LoginResponse = {
  access_token: string;
  token_type: string;
  expires_in: number;
  scope: string;
  userName: string;
  userId: number;
};

export type TokenData = {
  exp: number;
  user_name: string;
  authorities: Role[];
};

export const getTokenData = (): TokenData | undefined => {
  try {
    return jwtDecode(getAuthData().access_token) as TokenData;
  } catch (error) {
    return undefined;
  }
};

export const getSessionData = () => {
  const sessionData = localStorage.getItem('authData') ?? '{}';
  const parsedSessionData = JSON.parse(sessionData);

  return parsedSessionData as LoginResponse;
};

export const getAccessTokenDecoded = () => {
  const sessionData = getSessionData();

  try {
    const tokenDecoded = jwtDecode(sessionData.access_token);
    return tokenDecoded as TokenData;
  } catch (error) {
    return {} as TokenData;
  }
};

export const isAuthenticated = (): boolean => {
  const tokenData = getTokenData();
  return tokenData && tokenData.exp * 1000 > Date.now() ? true : false;
};

export const isAllowedByRole = (routeRoles: Role[] = []) => {
  if (routeRoles.length === 0) {
    return true;
  }
  const { authorities } = getAccessTokenDecoded();

  return routeRoles.some((role) => authorities?.includes(role));
};

export const hasAnyRoles = (roles: Role[]): boolean => {
  if (roles.length === 0) {
    return true;
  }

  const tokenData = getTokenData();

  if (tokenData !== undefined) {
    return roles.some((role) => tokenData.authorities.includes(role));
  }

  return false;
};
