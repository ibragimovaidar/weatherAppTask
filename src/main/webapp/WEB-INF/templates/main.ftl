<#ftl encoding="UTF-8"/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>WeatherApp</title>
    <style>
        .weatherForm {
            margin-top: 50px;
            margin-bottom: 50px;
        }

        .widget {
            border-radius: 15px;
            padding: 10px;
            background: lightgray;
            font-weight: 500;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="row form">
        <div class="col-md-4"></div>
        <div class="col-md-4 weatherForm">
            <form id="weatherForm" action="/weather">
                <div class="mb-3">
                    <label for="query" class="form-label">Город</label>
                    <input type="text" class="form-control" id="query" name="query" aria-describedby="query">
                    <div id="query" class="form-text">Введите название города</div>
                </div>
                <button type="submit" class="btn btn-primary">Узнать погоду</button>
            </form>
        </div>
        <div class="col-md-4"></div>
    </div>
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <div class="widget">
                <p id="city">Город: </p>
                <p id="temp">Температура: </p>
                <p id="weatherDesc">Погода: </p>
                <br/>
                <p id="windSpeed">Скорость ветра:</p>
                <p id="wind">Направление ветра:</p>
                <br/>
                <p id="pressure">Направление ветра:</p>
            </div>
        </div>
        <div class="col-md-3"></div>
    </div>
</div>
<!-- ajax google cdn -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- Bootstrap JavaScript Libraries -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

<script>
    $('#weatherForm').submit(function(e){
        e.preventDefault();

        var form = $(this)
        var url = form.attr('action')

        $.ajax({
            type: "POST",
            url: url,
            data: form.serialize(),
            success: function(data) {
                $('#city').text('Город: ' + data['name'])
                $('#temp').text('Температура: ' + data['temp'] + '°C')
                $('#weatherDesc').text('Погода: ' + data['weatherDesc'])

                $('#windSpeed').text('Скорость ветра: ' + data['windSpeed'])
                $('#wind').text('Направление ветра: ' + data['wind'])

                $('#pressure').text('Давление: ' + data['pressure'] + '°C')

            },
            error: function(){
                console.assert("Город введен неверно");
            }
        });
    });
</script>
</body>
</html>