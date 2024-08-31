



function drawBorderBottomToSelectPage(page){

    $('#j-paging .j-page-num').css('border', 'none');
    $('#j-paging .j-page-num').eq(page-1).css('border-bottom','1.5px solid black');
    $('#j-paging').on('click','.j-page-num',function(){

        let page = $(this).text().trim();
        let search = location.search;
        console.log(search);
        location.href="/"+page+search;
    })

}