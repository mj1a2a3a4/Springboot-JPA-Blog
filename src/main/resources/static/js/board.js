let index = {
	init: function(){
		$("#btn-save").on("click",()=>{ //function() {}를 안쓴 이유는 , ()=>{} this를 바인딩하기 위해서
			this.save();
		});
		$("#btn-delete").on("click",()=>{ 
			this.deleteById();
		});
		$("#btn-update").on("click",()=>{ 
			this.update();
		});
		$("#btn-reply-save").on("click",()=>{ 
			this.replySave();
		});
	},
	save: function(){
		let data = {
			title : $("#title").val(),
			content : $("#content").val(),
			
		};
		//console.log(data);
		
		//ajax 호출시 default가 비동기 호출
		$.ajax({
			type: "POST",
			url : "/api/board",
			data : JSON.stringify(data), //http body 데이터
			contentType: "application/json; charset=utf-8", //body데이터가 어떤 타입인지(mime)
			dataType: "json" //요청을 서버로 해서 응답이 왔을 때 기본적으로 모든 것이 String (생긴게 JSON이라면 )=> javascript 오브젝트로 변경
		}).done(function(resp){
			alert("글쓰기가 완료되었습니다.");
			console.log(resp);
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); // ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청!
	},
	deleteById: function(){		
		let id = $("#id").text();
		
		//ajax 호출시 default가 비동기 호출
		$.ajax({
			type: "DELETE",
			url : "/api/board/"+id,
			dataType: "json" //요청을 서버로 해서 응답이 왔을 때 기본적으로 모든 것이 String (생긴게 JSON이라면 )=> javascript 오브젝트로 변경
		}).done(function(resp){
			alert("삭제가 완료되었습니다.");
			console.log(resp);
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); // ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청!
	},
	update: function(){
		let id = $("#id").val();
		let data = { 
			title : $("#title").val(),
			content : $("#content").val(),
			
		};
		//console.log(data);
		
		//ajax 호출시 default가 비동기 호출
		$.ajax({
			type: "PUT",
			url : "/api/board/"+id,
			data : JSON.stringify(data), //http body 데이터
			contentType: "application/json; charset=utf-8", //body데이터가 어떤 타입인지(mime)
			dataType: "json" //요청을 서버로 해서 응답이 왔을 때 기본적으로 모든 것이 String (생긴게 JSON이라면 )=> javascript 오브젝트로 변경
		}).done(function(resp){
			alert("글수정이 완료되었습니다.");
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); // ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청!
	},
	replySave: function(){
		let data = {
			content : $("#reply-content").val()
		};
		let boardId = $("#boardId").val();
		//console.log(data);
		
		//ajax 호출시 default가 비동기 호출
		$.ajax({
			type: "POST",
			url : `/api/board/${boardId}/reply`,
			data : JSON.stringify(data), //http body 데이터
			contentType: "application/json; charset=utf-8", //body데이터가 어떤 타입인지(mime)
			dataType: "json" //요청을 서버로 해서 응ss답이 왔을 때 기본적으로 모든 것이 String (생긴게 JSON이라면 )=> javascript 오브젝트로 변경
		}).done(function(resp){
			alert("댓글 작성이 완료되었습니다.");
			console.log(resp);
			location.href=`/board/${boardId}`;
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); // ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청!
	}
}
index.init();