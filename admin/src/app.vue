<template>
    <div id="app">
        <router-view/>
    </div>
</template>

<script>
  $('body').attr('class', 'login-layout light-login');
  export default {
    name: 'app',
  }
</script>
