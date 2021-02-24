<script lang="ts">
  import { executeFunction } from "../core";

  const test = executeFunction("income");
</script>

<h1>Income works {$test?.value}</h1>
