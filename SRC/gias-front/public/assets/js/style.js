$(function(){
	
	
    //레이아웃
    
	//레이아웃 - 메뉴
	$('.gnb > ul > li > a,.gnb > ul > li > button').click(function(){
		var menuSibling = $(this).parent('li').siblings('li');
		menuSibling.removeClass('on');
		$(this).parent('li').addClass('on');
		menuSibling.children('ul').slideUp(300);
	})
	$('.gnb > ul > li > button').click(function(){
		$(this).siblings('ul').slideToggle(300);
	})
	$('.gnb__menu ul > li.on').parent('ul').show();
	
	//레이아웃 - 메뉴 - collase/expand
	$('.btn__collapse').click(function(){
		$('.header').toggleClass('collapsed');
	})
	
	//레이아웃 - 메뉴 - mobile
	$('.btn__gnb').click(function(){
		$('.header').toggleClass('menu-on');
	})
	$('.gnb__bg').click(function(){
		$('.header').removeClass('menu-on');
	})
	
	//레이아웃 User name initial
	var userName = $('.login-info__name em').text();
	var userInitial = userName.charAt(0);
	$('.login-info__initial span').html(userInitial);
	
	
	//Tab
	$('.tab').each(function(){
		$(this).children('button').click(function(){
			var tabIndex = $(this).index();
			var tabBox = $(this).parent('.tab').siblings('.tab__contents').children('.tab__box');
			tabBox.removeClass('active');
			tabBox.eq(tabIndex).addClass('active');
			
			$(this).siblings('button').removeClass('on');
			$(this).addClass('on');
		})
	})
    
    
    //input wrap
    $('.input-wrap > input').each(function(){
		var inputWrap = $(this).parent('.input-wrap');
		$(this).focusin(function(){
			inputWrap.addClass('on');
		})
		$(this).focusout(function(){
			inputWrap.removeClass('on');
			if($(this).val().length > 0) {
				inputWrap.addClass('on');
			}else{
				inputWrap.removeClass('on');
			}
		})
	})
    
    
    //팝업
    $('.popup__close,.popup__bg,.popup__exit').click(function(){
        var thisPop = $(this).parents('.popup');
        thisPop.addClass('closing');
        setTimeout(function(){
            thisPop.removeClass('active');
            thisPop.removeClass('closing');
        },400);
    })

    
    //아코디언
    $('.accordian__top').click(function(){
        $(this).toggleClass('active');
        $(this).siblings('.accordian__body').slideToggle();
        $(this).parent('.accordian__wrap').siblings('.accordian__wrap').children('.accordian__body').slideUp();
        $(this).parent('.accordian__wrap').siblings('.accordian__wrap').children('.accordian__top').removeClass('active');
    })
    
    
    //For source code layout
	$('.source__btn').each(function(){
		$(this).click(function(){
			$(this).toggleClass('on');
			$(this).next('.source__code').slideToggle('active');
		})
	})
	
	$('.cat-setting__list > button').click(function(){
		$(this).addClass('on');
		$(this).siblings('button').removeClass('on');
	})
	
})