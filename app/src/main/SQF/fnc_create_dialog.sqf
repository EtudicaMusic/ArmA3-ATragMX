#include "script_component.hpp"

if (dialog) exitWith { false };
if (underwater player) exitWith { false };
if (!("ATragMX" in (uniformItems player)) && !("ATragMX" in (vestItems player))) exitWith { false };

execVM "\atragmx\fnc_update_target_selection.sqf";

createDialog 'ATragMX_Display';

true execVM "\atragmx\fnc_show_main_page.sqf";

false execVM "\atragmx\fnc_show_add_new_gun.sqf";
false execVM "\atragmx\fnc_show_gun_list.sqf";
false execVM "\atragmx\fnc_show_range_card.sqf";
false execVM "\atragmx\fnc_show_range_card_setup.sqf";
false execVM "\atragmx\fnc_show_target_range_assist.sqf";
false execVM "\atragmx\fnc_show_target_speed_assist.sqf";
false execVM "\atragmx\fnc_show_target_speed_assist_timer.sqf";

{
	lbAdd [6000, _x select 0];
} forEach ATragMX_gunList;

true
