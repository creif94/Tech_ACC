    // **Promises: Old way to do async, Good method if there's a function that is going to take a long time to run in the
    // **background. * Used to replace Callbacks *

//**************************************************************************
let p = new Promise((resolve, reject)=>{
    let a = 1+1
    if (a===3){
        resolve('Success')
    } else{ reject('Failed')}
})
p.then((message)=>{
    console.log(message)
}).catch((message)=>{
    console.log('this is the catch '+ message)
})
//**************************************************************************
    // **Things to do with promises:
    // **Let's say that video 1 takes forever to download, video 2 and 3 would still run without having to wait for video 1
const recordVideoOne = new Promise((resolve, reject)=>{
    resolve('Video 1 Recorded')
})
const recordVideoTwo = new Promise((resolve, reject)=>{
    resolve('Video 2 Recorded')
})
const recordVideoThree = new Promise((resolve, reject)=>{
    resolve('Video 3 Recorded')
})

    // **Let's say that we want to run all of these in Parallel, You can do this ->
    // **Will wait for everything to complete before returning the message
Promise.all([
    recordVideoOne,
    recordVideoTwo,
    recordVideoThree
]).then((message) => { // going to send an array of all the resolve responses.
    console.log(message)
})
    // **Does not wait for everything to finished before executing. Will execute when one of them is complete
    // **Will only return a single value instead of an array like Promise.all([]).then(()=>{})
Promise.race([
    recordVideoOne,
    recordVideoTwo,
    recordVideoThree
]).then((message) => { // going to send an array of all the resolve responses.
    console.log(message)
})
//**************************************************************************
    //**Async and Await
    //** Have to use try catch blocks
