angular.module('app').controller('storeController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/market';

    $scope.fillTable = function (pageIndex = 1) {
        $http({
            url: contextPath + '/api/v1/products',
            method: 'GET',
            params: {
                title: $scope.filter ? $scope.filter.title : null,
                min_price: $scope.filter ? $scope.filter.min_price : null,
                max_price: $scope.filter ? $scope.filter.max_price : null,

                p: pageIndex
            }
        })
            .then(function (response) {
                $scope.CategoriesPage  = $scope.getAllCategories(pageIndex);
                $scope.ProductsPage = response.data;
                $scope.PaginationArray = $scope.generatePagesInd(1, $scope.ProductsPage.totalPages);

            });
    };

    $scope.getAllCategories = function (pageIndex = 1) {
        $http({
            url: contextPath + '/api/v1/category',
            method: 'GET',
            params: {
                p: pageIndex
            }
        })
            .then(function (response) {
                $scope.CategoriesPage = response.data;
            });
    };

    $scope.addToCart = function (productId) {
        $http({
            url: contextPath + '/api/v1/cart/add/' + productId,
            method: 'GET'
        })
            .then(function (response) {
                console.log('ok');
            });
    }

    $scope.generatePagesInd = function(startPage, endPage) {
        let arr = [];
        for (let i = startPage; i < endPage + 1; i++) {
            arr.push(i);
        }
        return arr;
    }

    $scope.fillTable();
});