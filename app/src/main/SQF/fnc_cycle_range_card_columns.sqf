#include "script_component.hpp"

ATragMX_rangeCardCurrentColumn = (ATragMX_rangeCardCurrentColumn + 1) % (count ATragMX_rangeCardLastColumns);

ctrlSetText [5006, (ATragMX_rangeCardLastColumns select ATragMX_rangeCardCurrentColumn)];

call compile preprocessFile ("\atragmx\fnc_update_range_card.sqf");
