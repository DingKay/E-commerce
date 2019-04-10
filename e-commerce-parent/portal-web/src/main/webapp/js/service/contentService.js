app.service("contentService",function($http){
    this.findByCategoryId1 = function(categoryId){
        return $http.get("content/findByCategoryId.do?categoryId="+categoryId);
    }
});