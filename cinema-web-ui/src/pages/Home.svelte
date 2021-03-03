<script lang="ts">
  import type { Observable } from "rxjs";

  import { executeFunction } from "../core";
  import type { Cinema, CinemaResponse } from "../model/data";

  const cinemas: Observable<CinemaResponse<Cinema[]>> = executeFunction("getAllCinemas");
</script>

<h1>Home</h1>
{#if $cinemas}
  {#each $cinemas.value as cinema}
    {cinema.nameOfCinema}
  {/each}
{/if}
