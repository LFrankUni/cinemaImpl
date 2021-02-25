<script lang="ts">
  import { link } from "svelte-spa-router";
  import type { Route } from "../../model";
  export let routes: Route[];
</script>

<header>
  {#each routes as route}
    <!-- svelte-ignore a11y-missing-attribute -->
    <a use:link={route.path}>{route.name}</a>
  {/each}
</header>
