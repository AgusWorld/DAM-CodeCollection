
$(`ul li:nth-child(1) a`).click(function (){
    $(`ul li:nth-child(4) a`).removeClass("active");
    $(`ul li:nth-child(2) a`).removeClass("active");
    $(`ul li:nth-child(3) a`).removeClass("active");
    $(`ul li:nth-child(1) a`).addClass("active");
    $(`div.tab-content div:nth-child(4)`).removeClass("active");
    $(`div.tab-content div:nth-child(2)`).removeClass("active");
    $(`div.tab-content div:nth-child(3)`).removeClass("active");
    $(`div.tab-content div:nth-child(1)`).addClass("active");
})

$(`ul li:nth-child(2) a`).click(function (){
    $(`ul li:nth-child(1) a`).removeClass("active");
    $(`ul li:nth-child(4) a`).removeClass("active");
    $(`ul li:nth-child(3) a`).removeClass("active");
    $(`ul li:nth-child(2) a`).addClass("active");
    $(`div.tab-content div:nth-child(1)`).removeClass("active");
    $(`div.tab-content div:nth-child(4)`).removeClass("active");
    $(`div.tab-content div:nth-child(3)`).removeClass("active");
    $(`div.tab-content div:nth-child(2)`).addClass("active");
})

$(`ul li:nth-child(3) a`).click(function (){
    $(`ul li:nth-child(1) a`).removeClass("active");
    $(`ul li:nth-child(2) a`).removeClass("active");
    $(`ul li:nth-child(4) a`).removeClass("active");
    $(`ul li:nth-child(3) a`).addClass("active");
    $(`div.tab-content div:nth-child(1)`).removeClass("active");
    $(`div.tab-content div:nth-child(2)`).removeClass("active");
    $(`div.tab-content div:nth-child(4)`).removeClass("active");
    $(`div.tab-content div:nth-child(3)`).addClass("active");
})

$(`ul li:nth-child(4) a`).click(function (){
    $(`ul li:nth-child(1) a`).removeClass("active");
    $(`ul li:nth-child(2) a`).removeClass("active");
    $(`ul li:nth-child(3) a`).removeClass("active");
    $(`ul li:nth-child(4) a`).addClass("active");
    $(`div.tab-content div:nth-child(1)`).removeClass("active");
    $(`div.tab-content div:nth-child(2)`).removeClass("active");
    $(`div.tab-content div:nth-child(3)`).removeClass("active");
    $(`div.tab-content div:nth-child(4)`).addClass("active");
})