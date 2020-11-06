angular.module('app').controller('userprofileController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/market';

    $scope.userdetailContentRequest = function () {
        $http({
                    url: contextPath + '/api/v1/userprofile',
                    method: 'GET'
                })
                    .then(function (response) {
                        console.log(response.data);
                        $scope.userdatail = response.data;
                    });
    };

    $scope.createOrder = function (){
            $http.post(contextPath + '/api/v1/userprofile', $scope.newProduct)
                                        .then(function (response) {
                                            $scope.newProduct = null;
                                            alert('Добавлен новый продукт');
                                        });

            $http.post(contextPath + '/api/v1/userprofile', $scope.userdatail)
                   .then(function (response) {
                        $scope.userdatail = null;
                        alert("Профиль успешно обновлен");
                         $scope.userdetailContentRequest();
                   });



        }
    $scope.userdetailContentRequest();
});