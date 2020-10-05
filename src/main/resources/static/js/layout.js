window.onload   = function () {
    if (localStorage.getItem('state')) {
        setstate()
    }

    function setstate() {
        document.getElementById('wrapper').className = localStorage.getItem('state')
        // document.getElementById('sidebar-wrapper').style.transition = "all 0s";
    }

    $("#menu-toggle").click(function (e) {
        e.preventDefault();
        document.getElementById('sidebar-wrapper').style.transition = "all 1s";
        $("#wrapper").toggleClass("toggled");
        localStorage.setItem('state', (document.getElementById('wrapper').className))
    });
}