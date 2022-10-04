// //functional:
// const FuncPerson = function(name, age){
//     const obj={}
//     obj.name= name;
//     obj.age=age;
//
//     obj.greet
//
//     obj.greet = functinon()
//     {
//         console.log('I am ${name}');
//     }
//     obj.ask= () =>{
//         console.log('I am  ${age}. How wold are you?');
//     }
//     const anthony = FuncPerson('Chris', 20)
//     anthony.ask()
//     anthony.greet()
// }
//
// // Prototypal
// constPersonMethods = {
//     greet: function(){
//         console.log('I am  ${age}. How wold are you?');
//     },
//     ask: () => {
//         console.log('I am  ${age}. How wold are you?');
//     },
// }
// const ProtoPerson = function(name, age){
//     const obj = Object.create(PersonMethods);
// }

// Classes: --> ES6 Class
class Person{
    //Don't need to pre-assign a variables
    //Constructor is essentially the same
    constructor(name, age){
        this.name=name;
        this.age=age;
    }
    greet(){
        //logic goes here
        console.log(`Hello, my name is ${this.name}`)
    }
    //Method ask
    ask(){
        //logic goes here
        console.log(`My age is ${this.age}, what is your age?`)
    }
}
const chris = new Person('Chris', 30)
chris.ask();
chris.greet();
// My age is 30, what is your age?
// Hello, my name is Chris