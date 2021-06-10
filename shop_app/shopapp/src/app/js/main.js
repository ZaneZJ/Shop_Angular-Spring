jQuery(function($) {

    /* Progress Bar */

    function animateProgressBar(){
        // This is then function used to detect if the element is scrolled into view
        function elementScrolled(elem)
        {
          var docViewTop = $(window).scrollTop();
          var docViewBottom = docViewTop + $(window).height();
          var elemTop = $(elem).offset().top;
          return ((elemTop <= docViewBottom) && (elemTop >= docViewTop));
        }
      
        // This is where we use the function to detect if ".box2" is scrolled into view, and when it is add the class ".animated" to the <p> child element
        if(elementScrolled('.progress-bar')) {
            $('.progress-bar').each((i, bar) => {
            const element = $(bar);
            element.width(`${element.attr("aria-valuenow")}%`);
            $(window).off("scroll", animateProgressBar);
            })
        }
    }
    $(window).scroll(animateProgressBar);
  
    
    /*-- Strict mode enabled --*/
    "use strict";

    var glide = new Glide('.glide', {
        type: 'slider',
        autoplay: 2000,
        hoverpause: true,
        focusAt: 'center',
        perView: 5
    }).mount()

    function expandGlideMiddle() {
        const middle = $($(".glide__slide:not(.glide__slide--clone)")[glide.index]);
        $(".glide__slide--active-sibling").removeClass("glide__slide--active-sibling");
        $(".glide__slide--active--active").removeClass("glide__slide--active--active");
        middle.prev().addClass("glide__slide--active-sibling");
        middle.next().addClass("glide__slide--active-sibling");
        middle.addClass("glide__slide--active--active")
    }

    expandGlideMiddle()

    glide.on('move', expandGlideMiddle)

    // glide.on('run.after', function(move) {
    //     console.log(move)
    //     $(".glide__slide--active-sibling").removeClass("glide__slide--active-sibling");
    //     $(".glide__slide--active").prev().addClass("glide__slide--active-sibling");
    //     $(".glide__slide--active").next().addClass("glide__slide--active-sibling");
    //   })

    
    // $('.splide').slick({
    //     centerMode: true,
    //     centerPadding: '60px',
    //     slidesToShow: 3,
    //     responsive: [
    //     {
    //         breakpoint: 768,
    //         settings: {
    //         //   arrows: false,
    //         centerMode: true,
    //         centerPadding: '40px',
    //         slidesToShow: 3
    //         }
    //     },
    //     {
    //         breakpoint: 480,
    //         settings: {
    //         //   arrows: false,
    //         centerMode: true,
    //         centerPadding: '40px',
    //         slidesToShow: 1
    //         }
    //     }
    //     ]
    // });

    // new Splide( '.splide', {
    //     type     : 'loop',
    //     autoWidth: true,
    //     height: "350px",
    //     focus    : 'center',
    // }).mount();


    new Rellax('.phone-1', {
        horizontal: true
    });
    new Rellax('.phone-2', {
        horizontal: true
    });
    new Rellax('.phone-3', {
        horizontal: true
    });

    var _document = $(document),
        _window = $(window),
        _navbarCollapse = $('.navbar-collapse'),
        _navbarToggler = $('.navbar-toggler');

    //animated navbar-toggler button
    _document.on('click', '.navbar .navbar-toggler', function() {
        $(this).toggleClass("change");
    });

    //Close menu when clicked menu-items or outside
    $(".navbar-nav li a").on('click', function() {
        _navbarCollapse.removeClass('show');
        _navbarToggler.removeClass('change');
    });

    _document.on('click', function() {
        if (_navbarCollapse.hasClass('show')) {
            _navbarCollapse.removeClass('show');
            _navbarToggler.removeClass('change');
        }
    });

    //affixed nav with scrollspy
    $('body').scrollspy({
        target: ".navbar",
        offset: 200
    });

    // phone mask
    //$('.phone').mask('+7(700) 000 00 00');

    //Global Form validation
    $('.quote-form').on('submit', function(e) {
        e.preventDefault();
        var _self = $(this),
            data = $(this).serialize(),
            __selector = _self.closest('input, textarea');

        _self.closest('div').find('input,textarea').removeAttr('style');
        _self.find('.err-msg').remove();
        _self.find('.form-success').removeClass('form-success');

        $('.submit-loading-img').css('display', 'block');
        _self.closest('div').find('button[type="submit"]').attr('disabled', 'disabled');

        $.ajax({
            url: '/send.php',
            type: "post",
            data: data,
            success: function(data) {
                $('.submit-loading-img').css('display', 'none');
                _self.closest('div').find('button[type="submit"]').removeAttr('disabled');
                _self.find('button').before('<div class="success-msg">Thank you, your application has been accepted! We will contact you shortly.</div>');
                _self[0].reset();
                _self.find('.success-msg').css({
                    'display': 'block'
                });

                setTimeout(function() {
                    $('.success-msg').fadeOut('slow');
                }, 10000);
            }
        });
    });

    //script for page scroll to top and bottom
    _document.on('click', '.page-scroll', function() {
        if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
            var target = $(this.hash);
            target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
            if (target.length) {
                if (_window.width() < 768) {
                    if (target.selector === '#cynic-services' || target.selector === '#cynic-about') {
                        $('html, body').animate({
                            scrollTop: target.offset().top - 150
                        }, 1000, 'easeInOutExpo');
                    } else {
                        $('html, body').animate({
                            scrollTop: target.offset().top - 90
                        }, 1000, 'easeInOutExpo');
                    }
                } else {
                    if (target.selector === '#cynic-services' || target.selector === '#cynic-about') {
                        $('html, body').animate({
                            scrollTop: target.offset().top - 170
                        }, 1000, 'easeInOutExpo');
                    } else {
                        $('html, body').animate({
                            scrollTop: target.offset().top - 75
                        }, 1000, 'easeInOutExpo');
                    }
                }
                return false;
            }
        }
    });

    //Counter Up js
    $('.counter').counterUp({
        // time: 2000
    });

    //Global Form validation
    $('.quote-form').on('submit', function(e) {
        e.preventDefault();
        var _self = $(this),
            data = $(this).serialize(),
            __selector = _self.closest('input, textarea');

        _self.closest('div').find('input,textarea').removeAttr('style');
        _self.find('.err-msg').remove();
        _self.find('.form-success').removeClass('form-success');

        $('.submit-loading-img').css('display', 'block');
        _self.closest('div').find('button[type="submit"]').attr('disabled', 'disabled');

        $.ajax({
            url: 'email/email.php',
            type: "post",
            dataType: 'json',
            data: data,
            success: function(data) {
                $('.submit-loading-img').css('display', 'none');
                _self.closest('div').find('button[type="submit"]').removeAttr('disabled');
                if (data.code == false) {
                    _self.closest('div').find('[name="' + data.field + '"]').addClass('form-success');
                    _self.closest('div').find('[name="' + data.field + '"]').after('<div class="err-msg">*' + data.err + '</div>');
                } else {
                    _self.find('textarea').after('<div class="success-msg">' + data.success + '</div>');
                    _self[0].reset();
                    _self.find('.success-msg').css({
                        'display': 'block'
                    });

                    setTimeout(function() {
                        $('.success-msg').fadeOut('slow');
                    }, 5000);
                }
            }
        });
    });

    _window.on("load resize", function() {

        // Owl carousel with filter
        var _x = 5;
        var _projectOwl = $('.projects-carousel.owl-carousel').owlCarousel({
            margin: 0,
            nav: true,
            responsive: {
                0: {
                    items: 1
                },
                600: {
                    items: _x - 3
                },
                1025: {
                    items: _x - 2
                },
                1199: {
                    items: _x
                }
            }
        });

        // Clients carousel with filter


        var owl = $('.clients-carousel-wrapper.owl-carousel').owlCarousel({
            margin: 0,
            loop: true,
            nav: true,
            responsive: {
                0: {
                    items: 3
                },
                600: {
                    items: 4
                },
                1199: {
                    items: 5
                }
            }
        });

        //custom filter
        var _owlStage = $('.projects-carousel .owl-stage'),
            _owlItem = $('.projects-carousel .owl-item'),
            _leftMargin = _owlStage.find('.owl-item').width();

        $('.btn-filter-wrap').on('click', '.btn-filter', function() {
            var _filter = $(this).data('filter');
            if (!$(this).hasClass('btn-active')) {
                $(this).addClass('btn-active').siblings().removeClass('btn-active');
                _owlStage.find('.owl-item').css({
                    'display': 'none'
                });
                if (_filter === '*') {
                    _owlItem.fadeIn('slow');
                } else {
                    $(_filter).parent().fadeIn('slow');
                }
            }

            if ($(_filter).length >= _x && _window.width() > 991) {
                _owlStage.css({
                    'margin-left': -(_leftMargin / 2)
                });
                $('.project-showcase .owl-nav').css({
                    'display': 'block'
                });
            } else {
                _owlStage.css({
                    'margin-left': '0'
                });
                $('.project-showcase .owl-nav').css({
                    'display': 'none'
                });
            }
        });

        var _extraMargin = function() {
            if (_owlItem.length >= _x && _window.width() > 991) {
                _owlStage.css({
                    'margin-left': -(_leftMargin / 2)
                });
            }
        }
        _extraMargin();
    });

    // script for box-equal-height
    var maxHeight = 0,
        _equalHeight = function(eq) {
            $(eq).each(function() {
                $(this).find('.equalHeight').each(function() {
                    if ($(this).height() > maxHeight) {
                        maxHeight = $(this).height();
                    }
                });
                $(this).find('.equalHeight').height(maxHeight);
            });
        }
    _equalHeight('.equalHeightWrapper');

    //Change navbar style on scroll
    _window.on('scroll', function() {
        if (_window.scrollTop() >= 100) {
            $('.navbar').addClass('scrolled');
        } else {
            $('.navbar').removeClass('scrolled');
        }
    });

}(jQuery));


/*$(".btn-men").on("click touchstart", function() {
  $(".men").slideToggle("slow");
  return false;*/