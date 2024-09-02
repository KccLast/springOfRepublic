function openTab(tabName) {
    var i;
    var tabcontent = document.getElementsByClassName("tab-content");
    var tabbuttons = document.getElementsByClassName("tab-button");

    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].classList.remove("active");
    }

    for (i = 0; i < tabbuttons.length; i++) {
        tabbuttons[i].classList.remove("active");
    }

    document.getElementById(tabName).classList.add("active");
    event.currentTarget.classList.add("active");
}
