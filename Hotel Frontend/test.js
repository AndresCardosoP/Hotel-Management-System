$(document).ready(function() {
    // Intercept clicks on links
    $('nav ul li a').on('click', function(event) {
        // Prevent the default link behavior
        event.preventDefault();

        // Get the href attribute of the clicked link
        var targetPage = $(this).attr('href');

        // Log the targetPage URL to the console for debugging
        console.log('Target page:', targetPage);

        // Fetch the content of the target page using AJAX
        $.ajax({
            url: targetPage,
            success: function(data) {
                // Replace the content of the container with the fetched content
                $('.container').html(data);
            },
            error: function(xhr, status, error) {
                // Handle errors if any
                console.error('Error fetching page:', status, error);
            }
        });
    });
});
