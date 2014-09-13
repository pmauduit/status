<!DOCTYPE>
<html ng-app='status'>
<head>
    <title>geOrchestra Status</title>
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <link rel="stylesheet" href="http://getbootstrap.com/dist/css/bootstrap.min.css" type="text/css">
</head>

<body ng-controller="InstanceController">
<div class="container">
    <div class="header">
        <h3 class="text-muted">Available monitored geOrchestra instances</h3>
    </div>

    <div class="row">
        <ul class="list-group col-md-8">
            <li class="list-group-item" ng-repeat="instance in instances | filter">
                <button class="btn btn-default" ng-click="remove(key)">
                    <span class="glyphicon glyphicon-remove"></span>
                </button>
                <b>{{instance.host}}</b>
            </li>
        </ul>
    </div>

</div>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.0-beta.10/angular.min.js"></script>
<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
<script src="js/status.js"></script>
</body>
</html>