$(document).ready(function() {
    // wrap 인트로 후 content 숨기기
    $('.start').hide(); // .start 요소 숨기기
    $('#main_content').hide();
    $('.start').fadeIn(9500);
    // start 버튼 클릭 시 wrap 사라지고 content 나타나기
    $('.start').on('click', function() {
        $('#wrap').fadeOut(500, function() {
            $('#main_content').fadeIn(500);
            setTimeout(function() {
                /* typing js */
                var str = '쉽고 재밌어 ';
                var typing = ' ';
                var i = 0;

                (function type() {
                    if (i < str.length) {
                        typing = typing + str.charAt(i);
                        $('.hcl_3').text(typing + '_');
                    } else {
                        $('.hcl_3').text(typing);
                        return false;
                    }

                    var ran = Math.floor(Math.random() * 300) + 150;
                    // This gives a random delay between each character so it feels more realistic.
                    // Set `ran` to a fixed number if you want consistent speed.

                    setTimeout(function() {
                        type();
                    }, ran);

                    i++;
                })();
                /* END */
            }, 4000); // 2초 딜레이 후 typing 함수 실행
        });
    });
// intro 끝

    //main 시작
    $(window).on('load', function() {
        var windowHeight = $(window).height();
        var footerHeight = $('footer').height();
        var heightDocument = windowHeight + $('.content').height() + $('footer').height() - 20;
        $('#main_content, #scroll-animate-main').css({
            'height': heightDocument + 'px'
        });
        $('.wrapper-parallax').css({
            'margin-top': windowHeight + 'px'
        });

        $(window).on('scroll', function() {
            var scroll = window.scrollY;
            $('#scroll-animate-main').css({
                'top': '-' + scroll + 'px'
            });
            $('header').css({
                'background-position-y': 50 - (scroll * 100 / heightDocument) + '%'
            });
            scrollFooter(scroll, footerHeight);
        });
    });

    function scrollFooter(scrollY, heightFooter) {
        console.log(scrollY);
        console.log(heightFooter);
        if (scrollY >= heightFooter) {
            $('footer').css({
                'bottom': '0px'
            });
        } else {
            $('footer').css({
                'bottom': '-' + heightFooter + 'px'
            });
        }
    };

});