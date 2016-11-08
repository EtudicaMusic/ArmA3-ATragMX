#include "script_component.hpp"

private ["_index"];
_index = lbCurSel 6000;

if (_index == -1) exitWith {};

for "_i" from 0 to (count ATragMX_currentGun) - 1 do {
	if ((ATragMX_currentGun select _i) > _index) then {
		ATragMX_currentGun set [_i, (ATragMX_currentGun select _i) - 1];
	};
};

ATragMX_gunList set [_index, 0];
ATragMX_gunList = ATragMX_gunList - [0];

lbDelete [6000, _index];

profileNamespace setVariable ["ATragMX_gunList", AtragMX_gunList];
