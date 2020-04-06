var car = {type:"Fiat", model:"500", color:"white"};
console.log(car.model);
const apps = ['WhatsApp', 'Instagram', 'Facebook'];
const playStore = [];

apps.forEach(function(item){
    playStore.push(item);
  console.log(item);
  console.log(playStore)
});
var x;
var y =[];
var fruits = ["Apple", "Banana", "Orange"];
for (x of fruits) {
    y.push(x)
  console.log(y);
}