angular.module('app').controller('categoryController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/market';

    $scope.fillTable = function (pageIndex = 1) {
        $http({
                url: contextPath + '/api/v1/category',
                method: 'GET',
                params: {
                    p: pageIndex
                }
            })
                .then(function (response) {
                    $scope.CategoriesPage = response.data;
                    $scope.PaginationArray = $scope.generateCategoriesInd(1, $scope.CategoriesPage.totalPages);
                });
    };


    $scope.generateCategoriesInd = function(startPage, endPage) {
            let arr = [];
            for (let i = startPage; i < endPage + 1; i++) {
                arr.push(i);
            }
            return arr;
        }

    $scope.fillTable();
});