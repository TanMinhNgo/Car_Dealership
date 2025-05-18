/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Animations
const staffloginButton = document.getElementById("stafflogin");
const customerloginButton = document.getElementById("customerlogin");
const container = document.getElementById("container");

staffloginButton.addEventListener("click", () => {
    container.classList.add("right-panel-active");
});

customerloginButton.addEventListener("click", () => {
    container.classList.remove("right-panel-active");
});

function showFields(role) {
    document.getElementById('mechanic-fields').classList.toggle('hidden', role !== 'mechanic');
    document.getElementById('sale-fields').classList.toggle('hidden', role !== 'sale');
}

function showSearch(role) {
    document.getElementById('searchbyid').classList.toggle('hidden', role !== 'id');
    document.getElementById('searchbydate').classList.toggle('hidden', role !== 'date');
}