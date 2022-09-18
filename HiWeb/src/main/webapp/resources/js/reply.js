/**
 * reply.js 모듈
 */

console.log("Reply Module.....");

let replyService = (function(){
	//return {name: "ABCD"};
	
	function add(reply, callback, error){
		console.log("add reply................");
		
		$.ajax({
			type: "post",
			url: "/replies/new",
			data: JSON.stringify(reply),
			contentType: "application/json; charset=utf-8",
			success: function(result){
				if(callback){
					callback(result);
				}
			},
			error: function(er){
				if(error){
					error(er);
				}
			}
		});
	}
	
	return {add: add};
})();  //즉시 실행 함수(빈 괄호)