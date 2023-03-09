import { createContext } from 'react';
import { TokenData } from 'util/auth';
import { LoginResponse } from 'util/storage';

export type AuthContextData = {
  authenticated: boolean;
  tokenData?: TokenData;
  loginResponse?: LoginResponse;
};

export type AuthContextType = {
  authContextData: AuthContextData;
  setAuthContextData: (authContextData: AuthContextData) => void;
};

export const AuthContext = createContext<AuthContextType>({
  authContextData: {
    authenticated: false,
  },
  setAuthContextData: () => null,
});
