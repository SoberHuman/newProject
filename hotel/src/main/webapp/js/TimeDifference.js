$(document).ready(function () {



    var dates = new Date();
    var years = dates.getFullYear();
    var monhs = dates.getMonth()+1;
    var days = dates.getDate();
    var dayss = dates.getDate()+7;
    if (monhs<10){
        $(".upTime").attr("min",years+"-"+0+monhs+"-"+days+"T00:00");
        // $(".upTime").attr("max",years+"-"+0+monhs+"-"+dayss+"T00:00");

        // $(".outTime").attr("max",years+"-"+0+monhs+"-"+dayss+"T00:00");
    }else{
        $(".upTime").attr("min",years+"-"+monhs+"-"+days+"T00:00");
        // $(".upTime").attr("max",years+"-"+monhs+"-"+dayss+"T00:00");
    }



        $(".upTime").on("blur",function () {
            var upTime = $(".upTime").val();
            console.log(upTime)
            $(".outTime").attr("min",upTime);

        })





    var date1 = null;
    var date2 = null;
    $(".upTime").on('input',function () {
        date1= $(".upTime").val().substring(0,10);
        date1= new Date(date1);
        $(".outTime").on('input',function () {
            date2= $(".outTime").val().substring(0,10);
            date2=new Date(date2);
            var day= Math.ceil((date2-date1)/(1000*60*60*24));
            if(day<=0){
                day=1;
            }
            $(".UpOutTime").val(day);
        })




    })
})