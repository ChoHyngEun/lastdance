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
                var words = ['매우', '어렵습니다.', '하지만 RainbowTeam과', '여러분이 함께라면', ' 쉽고 즐거워 집니다.'],
                    part,
                    i = 0,
                    offset = 0,
                    len = words.length,
                    forwards = true,
                    skip_count = 0,
                    skip_delay = 15,
                    speed = 70;
                var wordflick = function () {
                    setInterval(function () {
                        if (forwards) {
                            if (offset >= words[i].length) {
                                ++skip_count;
                                if (skip_count == skip_delay) {
                                    forwards = false;
                                    skip_count = 0;
                                }
                            }
                        }
                        else {
                            if (offset == 0) {
                                forwards = true;
                                i++;
                                offset = 0;
                                if (i >= len) {
                                    i = 0;
                                }
                            }
                        }
                        part = words[i].substr(0, offset);
                        if (skip_count == 0) {
                            if (forwards) {
                                offset++;
                            }
                            else {
                                offset--;
                            }
                        }
                        $('.hcl_3').text(part);
                    },speed);
                };

                $(document).ready(function () {
                    wordflick();
                });
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