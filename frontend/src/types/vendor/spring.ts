export type SpringPage<T> = {
  content: T[];
  last: boolean;
  totalElements: number;
  totalPages: number;
  size: number;
  number: number;
  first: boolean;
  numberOfElements?: number;
  empty: boolean;
};
