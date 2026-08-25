(function () {
    'use strict';

    const FILLED_CLASS = 'filled';
    const EMPTY_CLASS = 'empty';

    function updateDotGroup(radio) {
        const group = radio.closest('.dot-group');
        if (!group) return;
        const labels = group.querySelectorAll('label');
        const value = parseInt(radio.value);
        labels.forEach(function (label, index) {
            const dotValue = index + 1;
            if (dotValue <= value) {
                label.className = FILLED_CLASS;
            } else {
                label.className = EMPTY_CLASS;
            }
        });
    }

    document.addEventListener('DOMContentLoaded', () => {
        document.querySelectorAll('.dot-group input[type="radio"]').forEach(input => {
            input.addEventListener('change', function() {
                updateDotGroup(this);
            });
        });
    });
})();