document.addEventListener("DOMContentLoaded", () => {
    const form = document.querySelector("form");
    const requiredFields = form.querySelectorAll("input[required], select[required]");
    const provinceSelect = document.getElementById("province");
    const amphurSelect = document.getElementById("amphur");
    const districtSelect = document.getElementById("district");

    // Function to load amphurs based on selected province
    function loadAmphurs(provinceId) {
        if (!provinceId) {
            amphurSelect.innerHTML = '<option value="">Select amphur</option>';
            districtSelect.innerHTML = '<option value="">Select district</option>';
            return;
        }

        fetch(`/contacts/amphurs?provinceId=${provinceId}`)
            .then(response => response.json())
            .then(amphurs => {
                amphurSelect.innerHTML = '<option value="">Select amphur</option>';
                amphurs.forEach(amphur => {
                    const option = document.createElement("option");
                    option.value = amphur.id;
                    option.textContent = amphur.name;
                    amphurSelect.appendChild(option);
                });
            })
            .catch(error => console.error('Error loading amphurs:', error));
    }

    // Function to load districts based on selected amphur
    function loadDistricts(amphurId) {
        if (!amphurId) {
            districtSelect.innerHTML = '<option value="">Select district</option>';
            return;
        }

        fetch(`/contacts/districts?amphurId=${amphurId}`)
            .then(response => response.json())
            .then(districts => {
                districtSelect.innerHTML = '<option value="">Select district</option>';
                districts.forEach(district => {
                    const option = document.createElement("option");
                    option.value = district.id;
                    option.textContent = district.name;
                    districtSelect.appendChild(option);
                });
            })
            .catch(error => console.error('Error loading districts:', error));
    }

    // Event listener for province change
    provinceSelect.addEventListener("change", function() {
        loadAmphurs(this.value);
    });

    // Event listener for amphur change
    amphurSelect.addEventListener("change", function() {
        loadDistricts(this.value);
    });

    // Form validation
    form.addEventListener("submit", function(e) {
        let valid = true;
        requiredFields.forEach(field => {
            if (!field.value.trim()) {
                valid = false;
                field.style.borderColor = "#e53e3e";
                if (!field.nextElementSibling || !field.nextElementSibling.classList.contains("error-message")) {
                    const errorDiv = document.createElement("div");
                    errorDiv.className = "error-message text-red-500 text-xs mt-1";
                    errorDiv.textContent = "This field is required";
                    field.parentNode.insertBefore(errorDiv, field.nextSibling);
                }
            } else {
                field.style.borderColor = "#e2e8f0";
                if (field.nextElementSibling && field.nextElementSibling.classList.contains("error-message")) {
                    field.nextElementSibling.remove();
                }
            }
        });
        if (!valid) e.preventDefault();
    });

    // Real-time validation
    requiredFields.forEach(field => {
        field.addEventListener("blur", function() {
            if (!this.value.trim()) {
                this.style.borderColor = "#e53e3e";
            } else {
                this.style.borderColor = "#e2e8f0";
            }
        });
    });

    // Cancel button
    document.getElementById("cancelButton").addEventListener("click", function(e) {
        e.preventDefault();
        form.reset();
        document.querySelectorAll(".error-message").forEach(el => el.remove());
        requiredFields.forEach(f => f.style.borderColor = "#e2e8f0");
    });

    // Initialize amphurs if a province is already selected (for edit mode)
    if (provinceSelect.value) {
        loadAmphurs(provinceSelect.value);

        // If amphur is already selected, load districts too
        if (amphurSelect.value) {
            loadDistricts(amphurSelect.value);
        }
    }
});