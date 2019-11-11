<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/JSONC.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/lz-string.js"></script>
</head>
<body>

<form action="<%=request.getContextPath()%>/hello" method="POST">
<input type="hidden" name="imagenComprimida" id="imagenComprimida" value="informacion">
<input type="submit" name=enviarArchivo id="enviarArchivo" value="Subir">
</form>
<script type="text/javascript">
//var compressedJSON = JSONC.compress( myJson );

console.log("ID "+document.getElementById("enviarArchivo"));
//console.log("compressedJSON "+compressedJSON);
//console.log("myjson "+myJson.length);
//console.log("compressedJSON "+compressedJSON.length);



document.getElementById("enviarArchivo").addEventListener("click", function(e){
	e.preventDefault();
	 
	  var compressed = LZString.compressToUTF16(myJson);
	 
	  //console.log("Size of compressed sample is: " + compressed.length);
	 // var decompressed = LZString.decompress(compressed);
	  //console.log("decompressed "+decompressed);
	  document.getElementById("imagenComprimida").value = compressed;
	  console.log("compressed val:  "+document.getElementById("imagenComprimida").value);
	  window.document.forms[0].submit();
	  
	  /*compressToUTF16 / decompressFromUTF16
	  compressToBase64/ decompressFromBase64
	  compressToUint8Array/decompressFromUint8Array*/
	});
</script>
</body>
</html>