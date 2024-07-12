/**
 * 
 */
document.addEventListener('DOMContentLoaded', () => {
    const cartButton = document.getElementById('cart-button');
    const cartCount = document.getElementById('cart-count');
    let cartItems = 0;

    document.querySelectorAll('.add-to-cart').forEach(button => {
        button.addEventListener('click', () => {
            const itemName = button.getAttribute('data-name');
            const itemPrice = button.getAttribute('data-price');

            cartItems++;
            cartCount.textContent = cartItems;

            // Add item to localStorage (optional)
            let cart = JSON.parse(localStorage.getItem('cart')) || [];
            cart.push({ name: itemName, price: itemPrice });
            localStorage.setItem('cart', JSON.stringify(cart));

            alert(`${itemName} added to cart!`);
        });
    });
});


