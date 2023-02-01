$(document).ready(() => {

// $('.container-fluid')
// $('#id_')
// $('search-input')

    $('.minus').click(function () {

        // var text = $('#my_text').text();
        // $('#my_text').text('abc abc');



        var input = $(this).parent().find('input');

        var count = parseInt(input.val()) - 1;

        // if(count < 1){
        //     count = 1;
        // } else {
        //     count = count;
        // }

        count = count < 1 ? 1 : count;

        input.val(count);
        input.change();

        // $(this).parent().find('.my_text').text('!')

        return false;
    });

    $('.plus').click(function () {
        var input = $(this).parent().find('input');

        var count = parseInt(input.val()) + 1;

        // $(this).parent().find('input').val(count);

        input.val(count);
        input.change();

        return false;
    });

});