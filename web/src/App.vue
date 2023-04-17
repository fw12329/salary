<template>
  <form>
    <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">name</label>
    <input type="password" class="form-control" id="exampleInputPassword1" v-model="name">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" v-model="password">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">ConfirmedPassword</label>
    <input type="password" class="form-control" id="exampleInputPassword1" v-model="confirmedPassword">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</template>

<script>
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap'
import $ from 'jquery'
import {ref} from 'vue'

export default {
  name: 'App',
  components: {
    
  },
  setup:() => {
    let username = ref('');
    let password = ref('');
    let confirmedPassword = ref('');
    const register = () => {
      $.ajax({
        url:'http://127.0.0.1:8081/user/account/register',
        type:"post",
        data:{
          username:username.value,
          password:password.value,
          confirmedPassword:confirmedPassword.value
        },
        success(resp) {
          console.log(resp);
        }
      })
    }

    return{
      register
    }

  }
}
</script>

<style scoped>

</style>
