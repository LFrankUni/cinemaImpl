import type { Route } from "../model";
import Admin from "../pages/Admin.svelte";
import Home from "../pages/Home.svelte";

export const APP_ROUTES: Route[] = [
  {
    name: "Home",
    path: "/",
  },
  {
    name: "Admin",
    path: "/admin",
  },
];

export const APP_ROUTING = {
  "/": Home,
  "/admin": Admin,
  "*": Home,
};
