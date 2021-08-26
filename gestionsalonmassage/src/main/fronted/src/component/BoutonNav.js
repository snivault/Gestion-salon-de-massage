function BoutonNav (props)  {

	return (
		<a href={props.value} onClick={props.onClick}>{props.value}</a>
	);
	
}

export default BoutonNav;