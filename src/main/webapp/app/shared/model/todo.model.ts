export interface ITodo {
  id?: number;
  name?: string | null;
  description?: string | null;
}

export const defaultValue: Readonly<ITodo> = {};
