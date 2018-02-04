(function( $ ) {
    var elemId = "noid"; 
    $.fn.appendInput = function( options ) {
        if (options.getId) {
            elemId = options.getId();
        } else {
            elemId = options;
        }
        this.append("<input type='text' id='" + elemId + "' />");
    };
})(jQuery);

(function( $ ) {
    $.fn.waliduj = function( ) {
        var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        var form = $(this);
        form.children('input').each(function() {
            var isValid = re.test(String($(this).val()).toLowerCase());
            if (isValid) {
                if ($(this).next('p')) {
                    $(this).next('p').remove();
                }
            } else {
                var errorMessage = "<p>Error!</p>"
                if ($(this).next('p')) {
                    $(this).next('p').text(errorMessage);
                }
                $(this).after(errorMessage);
            }
        });
        
    };
})(jQuery);