
/////////////////////////////////////////////////
// NICE TO HAVE
/////////////////////////////////////////////////

serenade
	.language("java")
	.command("save",
		async(api, matches) => {
			await api.runCommand("format save");
		}
	);

serenade
	.language("java")
	.command("options",
		async(api, matches) => {
			await api.pressKey("return", ["alt"]);
		}
	);

/////////////////////////////////////////////////
// RXJAVA
/////////////////////////////////////////////////

serenade
	.language("java")
	.command("chain <%operator%>",
		async(api, matches) => {
			await api.runCommand("before semi insert dot camel " + matches.operator + " of");

			if (matches.operator === "observe on" || matches.operator === "subscribe on") {
				await api.runCommand("add argument capital schedulers dot");
			}
		},
		{
      autoExecute: true
    }
	);

serenade
	.language("java")
	.command("chain <%operator%> of <%var%>",
		async(api, matches) => {
			await api.runCommand("before semi insert dot camel " + matches.operator + " of");

			if (matches.operator === "observe on" || matches.operator === "subscribe on") {
				await api.runCommand("add argument capital schedulers dot " + matches.var + " of");
			}
			else {
				await api.runCommand("add argument " + matches.var);
			}
		},
		{
			autoExecute: true
		}
	);

serenade
	.language("java")
	.command("chain <%operator%> of <%var%> with <%contents%>",
		async(api, matches) => {
			await api.runCommand("before semi insert dot camel " + matches.operator + " of");
			await api.runCommand("add argument " + matches.var + " arrow");
			
			if (matches.contents === "body") {
				await api.runCommand("insert curly brackets");
				await api.runCommand("left enter");
			}
			else {
				await api.runCommand("insert " + matches.contents);
			}
		},
		{
			autoExecute: true
		}
	);

serenade
	.language("java")
	.command("chain <%operator%> of <%type%> colon <%function%>",
		async(api, matches) => {
			await api.runCommand("before semi insert dot camel " + matches.operator + " of");
			await api.runCommand("add argument capital " + matches.type + " colon colon");
			await api.runCommand("insert " + matches.function);
		},
		{
			autoExecute: true
		}
	);

serenade
	.language("java")
	.command("chain <%operator%> of print line",
		async(api, matches) => {
			await api.runCommand("before semi insert dot camel " + matches.operator + " of");
			await api.runCommand("add argument print line");
		},
		{
			autoExecute: true
		}
	);

/////////////////////////////////////////////////
// EXPAND TEXT
/////////////////////////////////////////////////

serenade
	.language("java")
	.snippet(
	"add argument print line",
    "System.out::println",
    {},
    "argument"
	);

serenade
	.language("java")
	.snippet(
	"insert print line",
    "System.out::println",
    {},
    "inline"
	);

serenade
	.language("java")
	.snippet(
	"add argument print line of",
    "System.out.println(<%cursor%>)",
    {},
    "argument"
	);

serenade
	.language("java")
	.snippet(
		"add argument print line <%x%>",
		"System.out.println(<%x%>)",
		{},
		"argument"
	);

serenade
	.language("java")
	.snippet(
		"add argument print line of <%x%>",
		"System.out.println(<%x%>)",
		{},
		"argument"
	);

serenade
	.language("java")
	.snippet(
		"insert print line of",
    "System.out.println(<%cursor%>)",
    {},
    "inline"
	);

serenade
	.language("java")
	.snippet(
		"insert print line <%x%>",
		"System.out.println(<%x%>)",
		{},
		"inline"
	);

serenade
	.language("java")
	.snippet(
		"insert print line of <%x%>",
		"System.out.println(<%x%>)",
		{},
		"inline"
	);

serenade
	.language("java")
	.snippet(
		"add main",
		"public static void main(String[] args) {\n\t<%cursor%>\n}",
		{},
		"inline"
	);
	
serenade
	.language("java")
	.snippet(
		"add argument integer array of <%x%>",
		"new Integer[] { <%x%> }",
		{},
		"argument"
	);

/////////////////////////////////////////////////
// MISC
/////////////////////////////////////////////////

serenade
	.language("java")
	.snippet(
		"add argument <%var%> arrow",
		"<%var%> -> ",
		{},
		"argument"
	);

serenade
	.language("java")
	.snippet(
		"add argument empty arrow",
		"() -> ",
		{},
		"argument"
	);

serenade
	.language("java")
	.command("add <%type%> list <%name%> of <%contents%>",
		async(api, matches) => {
			await api.runCommand("add list " + matches.type + " " + matches.name + " equals");
			await api.runCommand("insert arrays dot as list of " + matches.contents);
		},
		{
			autoExecute: true
		}
	);
	
serenade
	.language("java")
	.command("<%anything%> random int max <%num%>",
		async(api, matches) => {
			await api.runCommand(matches.anything + " new random of dot next int of " + matches.num);
		},
		{
			autoExecute: true
		}
	);

/////////////////////////////////////////////////
// PLACEHOLDER: Measure benefit once everything completed
/////////////////////////////////////////////////

serenade.language("java").hint("do subscribe");
serenade.language("java").hint("do on subscribe");
serenade.language("java").hint("do on complete");
serenade.language("java").hint("to upper case");
serenade.language("java").hint("arr");