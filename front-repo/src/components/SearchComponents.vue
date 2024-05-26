<template>


    <div class = "BookContainer">
        <div class="youareimage">
        <img :src="imageURL" alt = "Book Image" class = "book-image" />
        <h3>{{ title }}</h3>
        <p>{{ author }}</p>  <!-- {{ 여기 }} 안에 넣는건 뭐시기 바인딩...
                                          그런거고 또 imageUrl이 왜 안하냐면 :이 바인딩 하는거자너.-->

            </div   >
    </div>
    
</template>

<style scoped>


.BookContainer {
    width: 70%;
    border: 10px solid red;
    background-color: white;
}


</style>



<script setup> 

// eslint-disable-next-line no-unused-vars
const props = defineProps({
    title:{
        type: String,
        required: true
    },
    author: {
        type: String,
        required: true
    },
    imageURL: {
        type: String,
    }
})
</script>