document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('type').addEventListener('change', function () {
        var priceInput = document.getElementById('price');
        if (this.value === 'Single') {
            priceInput.value = 120;
        } else if (this.value === 'Double') {
            priceInput.value = 180;
        }
    });
});

document.addEventListener('DOMContentLoaded', function () {
    var typeInput = document.getElementById('type');
    var priceInput = document.getElementById('price');

    if (typeInput.value === 'Single') {
        priceInput.value = 120;
    } else if (typeInput.value === 'Double') {
        priceInput.value = 180;
    }

    typeInput.addEventListener('change', function () {
        if (this.value === 'Single') {
            priceInput.value = 120;
        } else if (this.value === 'Double') {
            priceInput.value = 180;
        }
    });
});


var Serviceprice = parseFloat(img.getAttribute('Serviceprice'));

function highlight(img, service, Serviceprice) {
    // Toggle the highlighted class
    img.classList.toggle('highlighted');
    
    // Update the value of the hidden input based on selected images
    var selectedServices = [];
    var totalPrice = 0;
    var highlightedImages = document.querySelectorAll('.listing img.highlighted');
    highlightedImages.forEach(function(image) {
        selectedServices.push(image.getAttribute('alt'));
        totalPrice += parseFloat(image.getAttribute('Serviceprice'));
    });
    
    // Update the value of the hidden input for selected services
    document.getElementById('selectedService').value = selectedServices.join(', ');
    
    // Update the value of the input field for the total price
    document.getElementById("servicePrice").value = totalPrice.toFixed(2);
}


function selectService(serviceType) {
    document.getElementById('selectedService').value = serviceType;
    document.getElementById('selectedServiceDisplay').innerText = "Selected Service Type: " + serviceType;
}
