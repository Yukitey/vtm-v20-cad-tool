(function () {
    'use strict';

    const SCROLL_BUTTON_ID = 'scroll-button';

    const scrollButton = document.getElementById(SCROLL_BUTTON_ID);
    if (scrollButton) {
        window.addEventListener('scroll', () => {
            if (window.scrollY > 300) {
                scrollButton.style.display = 'block';
            } else {
                scrollButton.style.display = 'none';
            }
        });

        scrollButton.addEventListener('click', (event) => {
            event.preventDefault();
            window.scrollTo({top: 0, behavior: 'smooth'})
        });
    }
})();