<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="CSS/loginANDregister.css">
</head>
<body>
    <header>
        <nav>
           <a href="index.jsp"> <div class="logo"><img src="images/logo.png" height="60px" alt="Tap Foods"></div></a>
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="#">Browse Restaurant</a></li>
                <li><a href="#">About Us</a></li>

                <li><a href="#">Contact</a></li>

                <li><a href="signup.jsp">Sign Up</a></li>
            </ul>
        </nav>
    </header>
    
    <section class="auth-section">
        <div class="floating-bubbles">
            <div class="bubble"></div>
            <div class="bubble"></div>
            <div class="bubble"></div>
            <div class="bubble"></div>
            <div class="bubble"></div>
        </div>
        <div class="auth-container">
            <div class="auth-left">
                <h2 class="hero-header">Log in to your account</h2>
                <button class="facebook-login">Login with Facebook</button>
                <p>- Or -</p>
                <form action="login">
                    <input type="text" name="email" placeholder="Mobile number or email" required="required">
                    <input type="password" name="password" placeholder="Password" required="required">
                    <a href="#" class="forgot-password">Forgot Password?</a>
                    <button type="submit" class="login-btn">Login</button>
                </form>
                <p class="switch-auth">Don't have an account? <a href="signup.html">Sign Up</a></p>
            </div>
        </div>
    </section>
    <section class="sliding-banner">
        <div class="banner-content">
            <p>Special Offer: Get 20% off on your first order! Use code: FIRST20</p>
        </div>
    </section>
    
    <footer>
        <p>2023 Tap Foods. All rights reserved.</p>
    </footer>
    <script src="JavaScript/loginANDsignup.js">
        window.addEventListener('scroll', function() {
            const nav = document.querySelector('nav');
            if (window.scrollY > 50) {
                nav.classList.add('scrolled');
            } else {
                nav.classList.remove('scrolled');
            }
        });
    </script>
</body>
</html>
