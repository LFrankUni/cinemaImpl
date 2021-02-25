<script lang="ts">
  import Router from "svelte-spa-router";
  import Header from "./components/shell/Header.svelte";
  import { APP_ROUTES, APP_ROUTING } from "./routes";
</script>

<Header routes={APP_ROUTES} />
<main>
  <Router routes={APP_ROUTING} />
</main>

<style>
</style>
