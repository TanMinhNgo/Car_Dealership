<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style >
    html, body {
    height: 100%;
    margin: 0;
    display: flex;
    flex-direction: column;
}

main {
    flex: 1; /* Đẩy footer xuống khi nội dung ngắn */
}

footer {
    background: #f3f4f6; /* Màu nền nhẹ */
    text-align: center;
    padding: 20px 0;
}

</style>
<footer class="bg-gray-100 py-10 mt-auto w-full">
    <div class="container mx-auto grid grid-cols-1 md:grid-cols-4 gap-8 text-gray-700">
        <!-- About Us Section -->
        <div>
            <h3 class="text-lg font-bold text-gray-900 mb-4">ABOUT US</h3>
            <p class="text-sm leading-6">
                We specialize in selling high-quality cars.<br />
                <span class="block mt-2">Address: Hi-Tech Park, Thu Duc City, Ho Chi Minh City</span>
                <span class="block mt-2">Customer Service Hotline: 0961618187</span>
                <span class="block mt-2">Email: fptshop@gmail.com</span>
            </p>
        </div>

        <!-- How to Buy Section -->
        <div>
            <h3 class="text-lg font-bold text-gray-900 mb-4">HOW TO BUY</h3>
            <ul class="space-y-2">
                <li><a href="#" class="hover:text-blue-500 transition">Warranty Center</a></li>
                <li><a href="#" class="hover:text-blue-500 transition">Refund Policy</a></li>
                <li><a href="#" class="hover:text-blue-500 transition">Order Guide</a></li>
                <li><a href="#" class="hover:text-blue-500 transition">Contact Us</a></li>
            </ul>
        </div>

        <!-- Policies Section -->
        <div>
            <h3 class="text-lg font-bold text-gray-900 mb-4">OUR POLICIES</h3>
            <ul class="space-y-2">
                <li><a href="#" class="hover:text-blue-500 transition">Privacy Policy</a></li>
                <li><a href="#" class="hover:text-blue-500 transition">Shipping Policy</a></li>
                <li><a href="#" class="hover:text-blue-500 transition">Warranty Policy</a></li>
                <li><a href="#" class="hover:text-blue-500 transition">Exchange Policy</a></li>
            </ul>
        </div>

        <!-- Follow Us Section -->
        <div>
            <h3 class="text-lg font-bold text-gray-900 mb-4">FOLLOW US</h3>
            <ul class="space-y-2">
                <li><a href="#" class="hover:text-blue-500 transition">Newsletter</a></li>
                <li><a href="#" class="hover:text-blue-500 transition">Instagram</a></li>
                <li><a href="#" class="hover:text-blue-500 transition">Facebook</a></li>
                <li><a href="#" class="hover:text-blue-500 transition">YouTube</a></li>
            </ul>
        </div>
    </div>

    <!-- Bottom Bar -->
    <div class="mt-10 border-t border-gray-300 text-center py-4 text-sm text-gray-500">
        &copy; 2025 - All Rights Reserved.
    </div>
</footer>
