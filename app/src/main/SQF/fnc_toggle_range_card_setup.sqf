#include "script_component.hpp"

#define _dsp (uiNamespace getVariable "ATragMX_Display")

if (ctrlVisible 10000) then
{
	false execVM "\atragmx\fnc_show_range_card_setup.sqf";
	true execVM "\atragmx\fnc_show_range_card.sqf";
	
	if (_this == 1) then
	{
		ATragMX_rangeCardStartRange = 0 max Round(parseNumber(ctrlText 10003)) min 3000;
		ATragMX_rangeCardEndRange = 0 max Round(parseNumber(ctrlText 10004)) min 3000;
		ATragMX_rangeCardIncrement = 1 max Round(parseNumber(ctrlText 10005)) min 3000;
		
		call compile preprocessFile ("\atragmx\fnc_calculate_range_card.sqf");
		call compile preprocessFile ("\atragmx\fnc_update_range_card.sqf");
	};
} else
{
	false execVM "\atragmx\fnc_show_range_card.sqf";
	true execVM "\atragmx\fnc_show_range_card_setup.sqf";
	
	ctrlSetFocus (_dsp displayCtrl 10006);
	
	ctrlSetText [10003, Str(Round(ATragMX_rangeCardStartRange))];
	ctrlSetText [10004, Str(Round(ATragMX_rangeCardEndRange))];
	ctrlSetText [10005, Str(Round(ATragMX_rangeCardIncrement))];
};
