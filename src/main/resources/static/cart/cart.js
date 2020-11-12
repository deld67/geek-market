angular.module('app').controller('cartController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/market';

    $scope.cartContentRequest = function () {
        $http({
            url: contextPath + '/api/v1/cart',
            method: 'GET'
        })
            .then(function (response) {
                console.log(response.data);
                $scope.cart = response.data;
            });
    };

    $scope.decrementItem = function (productId) {
        $http({
            url: contextPath + '/api/v1/cart/dec/' + productId,
            method: 'GET'
        })
            .then(function (response) {
                $scope.cartContentRequest();
            });
    };

    $scope.removeItem = function (productId) {
        $http({
            url: contextPath + '/api/v1/cart/remove/' + productId,
            method: 'GET'
        })
            .then(function (response) {
                $scope.cartContentRequest();
            });
    };

    $scope.incrementItem = function (productId) {
        $http({
            url: contextPath + '/api/v1/cart/add/' + productId,
            method: 'GET'
        })
            .then(function (response) {
                $scope.cartContentRequest();
            });
    };
    $scope.createOrder = function (){
        $http({
            url: contextPath + '/api/v1/orders',
            method: 'post',
            params:{
                address: $scope.details ? $scope.details.address : null,
                person:  $scope.details ? $scope.details.person : null
            }
        })
            .then(function(response){
                alert( "Заказ успешно оформлен");
                $scope.cartContentRequest();
            });
    }

    $scope.cartContentRequest();
});