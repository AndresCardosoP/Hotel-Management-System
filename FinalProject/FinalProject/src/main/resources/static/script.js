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
