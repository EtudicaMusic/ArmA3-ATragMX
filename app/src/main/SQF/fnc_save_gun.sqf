#include "script_component.hpp"

private ["_index"];
_index = 0 max (lbCurSel 6000);

ATragMX_gunList set [_index, +(ATragMX_workingMemory select ATragMX_currentTarget)];

lbClear 6000;
{
	lbAdd [6000, _x select 0];
} forEach ATragMX_gunList;

profileNamespace setVariable ["ATragMX_gunList", AtragMX_gunList];
