<?xml version="1.0" encoding="UTF-8"?>
<Document xmlns="urn:cnaps:std:ccms:2010:tech:xsd:ccms.805.001.02" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	<LoginReq>
		<GrpHdr>
			<MsgId>${MsgId}</MsgId>
			<CreDtTm>${CreDtTm}</CreDtTm>
			<InstgPty>
				<InstgDrctPty>${InstgDrctPty}</InstgDrctPty>
				<InstgPty>${InstgPty}</InstgPty>
			</InstgPty>
			<InstdPty>
				<InstdDrctPty>${InstdDrctPty}</InstdDrctPty>
				<InstdPty>${InstdPty}</InstdPty>
			</InstdPty>
			<SysCd>${SysCd}</SysCd>
			<Rmk>${Rmk!""}</Rmk>
		</GrpHdr>
		<LoginInf>
			<LoginOprTp>${LoginOprTp}</LoginOprTp>
		</LoginInf>
	</LoginReq>
</Document>