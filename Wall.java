import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {

    private List<Block> blocks;

    @Override
    public Optional<Block> findBlockByColor(String color) {
        for (Block block : blocks) {
            if (block instanceof CompositeBlock) {
                Optional<Block> foundBlock = findBlockByColorInCompositeBlock(color, (CompositeBlock) block);

                if(foundBlock.isPresent()) {
                    return foundBlock;
                }
            } else if (block.getColor().equals(color)) {
                return Optional.of(block);
            }
        }

        return Optional.empty();
    }

    private Optional<Block> findBlockByColorInCompositeBlock(String color, CompositeBlock compositeBlock) {
        for (Block block : compositeBlock.getBlocks()) {
            if (block instanceof CompositeBlock) {
                Optional<Block> foundBlock = findBlockByColorInCompositeBlock(color, (CompositeBlock) block);

                if(foundBlock.isPresent()) {
                    return foundBlock;
                }
            } else if (block.getColor().equals(color)) {
                return Optional.of(block);
            }
        }

        return Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {

        List<Block> blocksOfSpecificMaterial = new ArrayList<>();

        for(Block block : blocks) {
            if(block instanceof CompositeBlock) {
                blocksOfSpecificMaterial.addAll(getBlocksOfSpecificMaterialFromComposite(material, (CompositeBlock) block));
            } else if(block.getMaterial().equals(material)) {
                blocksOfSpecificMaterial.add(block);
            }
        }

        return blocksOfSpecificMaterial;
    }

    private List<Block> getBlocksOfSpecificMaterialFromComposite(String material, CompositeBlock compositeBlock) {

        List<Block> blocksOfSpecificMaterial = new ArrayList<>();

        for(Block block : compositeBlock.getBlocks()) {
            if(block instanceof CompositeBlock) {
                blocksOfSpecificMaterial.addAll(getBlocksOfSpecificMaterialFromComposite(material, (CompositeBlock) block));
            } else if(block.getMaterial().equals(material)) {
                blocksOfSpecificMaterial.add(block);
            }
        }

        return blocksOfSpecificMaterial;
    }

    @Override
    public int count() {
        int numOfBlocks = 0;

        for(Block block : blocks) {
            if(block instanceof CompositeBlock) {
                numOfBlocks += countBlocksInCompositeBlock((CompositeBlock) block);
            } else {
                numOfBlocks++;
            }
        }

        return numOfBlocks;
    }

    private int countBlocksInCompositeBlock(CompositeBlock compositeBlock) {
        int numOfBlocks = 0;

        for(Block block : compositeBlock.getBlocks()) {
            if(block instanceof CompositeBlock) {
                numOfBlocks += countBlocksInCompositeBlock((CompositeBlock) block);
            } else {
                numOfBlocks++;
            }
        }

        return numOfBlocks;
    }
}
